{% macro trim(table_name) %}
    {{ return(table_name[3:])}}
{% endmacro %}