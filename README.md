# Lab 2 (XML Parsers)

1. Create an ***XML file*** and its corresponding ***XSD schema***.
    - When developing the XSD, use simple and complex types, enumerations, boundary values, mandatory use of attributes, and the ID type.
2. Generate (create) Java class that corresponds to that description.
3. Create a Java application to parse XML document and initialise a collection of objects with information from the XML file.
    - Use ***SAX***, ***DOM*** and ***StAX*** parsers.
4. For sorting objects, use the ***Comparator*** interface.
5. Perform XML document validation using XSD.
6. Using ***XSL***, transform the XML file into a new XML format with a modified structure where the original list of elements is split into sublists by some characteristic, e.g., Type, Origin, etc.
7. Avoid code duplication.
8. All code must be covered by unit tests.
9. For outputting messages during the program's operation, use logging tools and approaches with a properly configured `Logger`.

## #9
**Candy**

- _Name_ – the name of the candy.
- _Energy_ – caloric content (kcal).
- _Type_ (can be multiple types) – the type of candy (caramel, toffee, chocolate [with or without filling]).
- _Ingredients_ (can be multiple) – ingredients: water, sugar (in mg), fructose (in mg), type of chocolate (for chocolates), vanillin (in mg).
- _Value_ – nutritional value: proteins (in grams), fats (in grams), carbohydrates (in grams).
- _Production_ – the manufacturing enterprise.
- The root element should be named **_Candy_**.
