package me.ialext.mining.api.data.model.annotation;

import me.ialext.mining.api.data.model.Model;

import java.lang.annotation.*;

/**
 * Defines the class where the {@link Model} will be bound to.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ModelImplementation {

  Class<? extends Model> value();

}
