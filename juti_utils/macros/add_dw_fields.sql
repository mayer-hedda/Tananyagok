{% macro add_dw_fields(st_table) %}

with typecasted as (
    {{ typecast(st_table) }}  -- Meghívjuk a typecast macrot
)

select
    t.*,                           -- Minden oszlop a typecast macro eredményéből
    current_timestamp as DW_ERV_KEZD,
    NULL::timestamp as DW_ERV_VEG  -- Új mező hozzáadása
from typecasted t

{% endmacro %}
