package me.ialext.mining.api.model.annotation;

import me.ialext.mining.api.model.Model;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface MaterializeClass {

  Class<? extends Model> value();

}
