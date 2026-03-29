--	JSON Operators
-- 	--------------
-- 	Operator 	Right Operand Type 	Description
--	-> 	int 	Get JSON array element
select '[1,2,3]'::json->2;

--	-> 	text 	Get JSON object field
select '{"a":1,"b":2}'::json->'b'

--	->> 	int 	Get JSON array element as text
select '[1,2,3]'::json->>2

--	->> 	text 	Get JSON object field as text
select '{"a":1,"b":2}'::json->>'b'

--	#> 	array of text 	Get JSON object at specified path
select '{"a":[1,2,3],"b":[4,5,6]}'::json#>'{a,2}'

--	#>> 	array of text 	Get JSON object at specified path as text
select '{"a":[1,2,3],"b":[4,5,6]}'::json#>>'{a,2}'



--	Additional operators
--	--------------------
--	@> 	jsonb 	Does the left JSON value contain within it the right value?
select '{"a":1, "b":2}'::jsonb @>'{"b":2}'::jsonb

--	<@ 	jsonb 	Is the left JSON value contained within the right value?
select '{"b":2}'::jsonb <@ '{"a":1,"b":2}'::jsonb

--	? 	text 	Does the key/element string exist within the JSON value?
select '{"a":1, "b":2}'::jsonb ? 'b'

--	?| 	text[] 	Do any of these key/element strings exist?
select '{"a":1, "b":2, "c":3}'::jsonb ?| array['b','c']

--	?& 	text[] 	Do all of these key/element strings exist? 
select '["a", "b"]'::jsonb ?& array['a', 'b']
