package org.ganimede.ortau.framework;

import org.ganimede.ortau.framework.loader.ProjectAnnotatedClassLoader;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import java.util.List;

@Named
@Singleton
public class InputScopeInitializer implements ScopeInitializer {
    @Inject
    ProjectAnnotatedClassLoader classLoader;

    @Override
    public List<Object> initialize() {
        classLoader.load(InputScoped.class);
        //TODO: Dependency Injection!!
        return null;
    }
}
