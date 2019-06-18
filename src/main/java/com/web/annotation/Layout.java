package com.web.annotation;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Documented
@Retention(RUNTIME)
@Target({ TYPE, METHOD })
public @interface Layout {
	/**
	 * no layout will be used
	 */
	String none = "none";
	/**
	 * default layout will be used
	 */
	String defaultLayOut = "layouts/default";

	String value() default defaultLayOut;
}
