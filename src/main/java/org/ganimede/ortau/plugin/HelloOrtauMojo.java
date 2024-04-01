package org.ganimede.ortau.plugin;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;

/**
 * Say hello to Ortau Framework with this Maven Mojo :).
 */
@Mojo(name="hello", defaultPhase = LifecyclePhase.COMPILE)
public class HelloOrtauMojo extends AbstractMojo {
    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        getLog().info("Hello Ortau");
    }
}
