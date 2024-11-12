{% macro add_meta_fields(st_table) %}

  {%- set st_fields_query %}
    WITH meta AS (
      SELECT st_field_name, bs_uk, istimestamp -- Select ts field as well
      FROM {{ source('meta', 'mt_st_field') }}
      WHERE st_table_name = '{{ st_table }}'
    )
    SELECT * FROM meta
  {% endset %}

  {% set st_fields_results = run_query(st_fields_query) %}

  {# Initialize arrays to track bs_uk and timestamp fields separately #}
  {% set bs_uk_fields = [] %}
  {% set timestamp_fields = [] %}

  {% for row in st_fields_results %}
    {% if row[1] is not none %} 
      {% do bs_uk_fields.append(row[0]) %}  {# Append bs_uk field #}
    {% endif %}
    {% if row[2] is not none %} 
      {% do timestamp_fields.append(row[0]) %}  {# Append ts field #}
    {% endif %}
  {% endfor %}

  {# Check if either bs_uk_fields or timestamp_fields is empty and raise specific errors #}
  {# {% if bs_uk_fields | length == 0 %}
    {% do exceptions.raise_compiler_error("Az MT_ST_META hiányos: nincs bs_uk érték") %}
  {% elif timestamp_fields | length == 0 %}
    {% do exceptions.raise_compiler_error("Az MT_ST_META hiányos: nincs istimestamp érték") %}
  {% else %} #}
    {# Combine both arrays for surrogate key construction #}
    {% set surrogate_key_fields = bs_uk_fields + timestamp_fields %}
    {{ dbt_utils.generate_surrogate_key(surrogate_key_fields) }} AS DW_BS_UK,
  {# {% endif %} #}
  {# Create additional meta fields #}
  CURRENT_TIMESTAMP::timestamp AS load_date,
  '{{ var("dag_run_id", "DBT") }}' AS DAGSTER_RUN_ID, 
  '{{ invocation_id }}' AS DBT_RUN_ID

{% endmacro %}
