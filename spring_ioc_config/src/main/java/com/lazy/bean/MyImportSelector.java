package com.lazy.bean;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        //可以以字符串的形式注册多个bean
        //字符串必须是类的完整限定名，获取bean只能根据类型获取
        return new String[]{"com.lazy.bean.Person",Wife.class.getName()};
    }
}
