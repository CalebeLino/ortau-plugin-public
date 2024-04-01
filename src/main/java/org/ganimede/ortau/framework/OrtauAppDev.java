package org.ganimede.ortau.framework;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

@Named
@Singleton
public class OrtauAppDev {
    @Inject
    Renderer<InputScoped> inputScopedRenderer;
}
