# Jackson Examples

## Filter out map entries with `null` value

```java
record User(@JsonSerialize(using = NonEmptySerializer.class) Map<String, Object> settings) {
}

class NonEmptySerializer extends JsonSerializer<Map<String, Object>> {

    @Override
    public void serialize(Map<String, Object> map, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        Map<String, Object> filteredMap = map.entrySet().stream()
            .filter(x -> x.getValue() != null)
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        gen.writeObject(filteredMap);
    }
}
```

With [StreamEx](https://github.com/amaembo/streamex) can be simplified to:

```java
Map<String, Object> filteredMap = EntryStream.of(map)
    .filterValues(Objects::nonNull)
    .toMap();
```
