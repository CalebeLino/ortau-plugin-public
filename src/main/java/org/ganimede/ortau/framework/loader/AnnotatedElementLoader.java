package org.ganimede.ortau.framework.loader;

import java.lang.annotation.Annotation;
import java.util.List;

public interface AnnotatedElementLoader<T> {
    List<T> load(Class<? extends Annotation> annotationClass);
}
