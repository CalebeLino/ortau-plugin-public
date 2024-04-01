package org.ganimede.ortau.framework.loader;

import org.apache.maven.project.MavenProject;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Named
@Singleton
public class ProjectAnnotatedMethodLoader implements AnnotatedElementLoader<Method> {
    @Inject
    MavenProject project;
    @Inject
    PackageTypesLoader typesLoader;

    @Override
    public List<Method> load(Annotation annotation) {
        List<Class<?>> projectClasses = new LinkedList<>();
        project.getCompileSourceRoots().forEach(root -> projectClasses.addAll(typesLoader.getPackageClasses(root)));

        return Stream.concat(
                projectClasses.stream()
                        .filter(clazz -> clazz.isAnnotationPresent(annotation.annotationType()))
                        .map(Class::getMethods)
                        .flatMap(Arrays::stream),

                projectClasses.stream()
                        .map(Class::getMethods)
                        .flatMap(Arrays::stream)
                        .filter(method -> method.isAnnotationPresent(annotation.annotationType()))
        ).collect(Collectors.toList());
    }
}
