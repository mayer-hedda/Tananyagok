{% macro tomb_bonto(json_path) %}

        case 
        	when ({{json_path}})::varchar = 'null'
        	then '[]'
        	else {{json_path}}
        end 

{% endmacro %}
