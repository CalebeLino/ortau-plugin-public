package org.ganimede.ortau.framework.renderer;

import org.ganimede.ortau.framework.InputScoped;
import org.ganimede.ortau.framework.Renderer;
import org.ganimede.ortau.framework.loader.AnnotatedElementLoader;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import java.lang.reflect.Method;

@Named
@Singleton
public class InputScopedRenderer implements Renderer<InputScoped> {
    @Inject
    AnnotatedElementLoader<Method> methodLoader;
    Renderer<InputScoped> instance;

    @Inject
    public InputScopedRenderer(AnnotatedElementLoader<Method> methodLoader) {
        this.methodLoader = methodLoader;
        instance = getInstance();
    }

    private Renderer<InputScoped> getInstance() {
        //TODO: Renderize proxy from scoped classes
        return null;
    }

    @Override
    public void execute() {
    }
}
