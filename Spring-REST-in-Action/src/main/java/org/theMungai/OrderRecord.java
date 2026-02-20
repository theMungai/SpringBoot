package org.theMungai;

/*
- We can also use Records to represent Java objects.
- You just declare fields in between parenthesis.
- This Record is automatically having constructor, getters(accessors), toString, equals and hashCode so we don't
need to write anything else.
 */
public record OrderRecord(
        String customerName,
        String productName,
        int quantity
) {

}
