package org.group40fs1project2.entity;

public class StringBufferConverter {

    public String convertToDatabaseColumn(StringBuffer stringBuffer){
        return stringBuffer.toString();
    }

    public StringBuffer convertToEntity(String string){
        return new StringBuffer(string);
    }
}
