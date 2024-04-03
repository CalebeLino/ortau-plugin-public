package org.ganimede.ortau.framework.loader;

import org.apache.maven.project.MavenProject;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.stream.Collectors;

@Named
@Singleton
public class ProjectAnnotatedClassLoader implements AnnotatedElementLoader<Class<?>> {
    @Inject
    MavenProject project;
    @Inject
    PackageTypesLoader typesLoader;
    @Override
    public List<Class<?>> load(Class<? extends Annotation> annotationClass) {
        return project.getCompileSourceRoots().stream()
                .map(root -> typesLoader.getPackageClasses(root))
                .flatMap(List::stream)
                .filter(clazz -> clazz.isAnnotationPresent(annotationClass))
                .collect(Collectors.toList());
    }
}
