package com.example.apt;

import com.squareup.javapoet.MethodSpec;

import javax.lang.model.element.Modifier;

public class Test {

    void genCode() {
        MethodSpec methodSpec = MethodSpec.methodBuilder("foo")
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                .addParameter(String[].class, "args")
                .addStatement("$T.out.println($S)", System.class, "Test Method")
                .returns(void.class)
                .build();
    }
}
