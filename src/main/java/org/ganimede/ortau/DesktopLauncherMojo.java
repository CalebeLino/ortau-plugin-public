package org.ganimede.ortau;


import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

/**
 * This Mojo implements a launching build for desktops. It requires an ortau project and an ortau application.
 */
@Mojo(name="desktop", defaultPhase = LifecyclePhase.COMPILE)
public class DesktopLauncherMojo extends AbstractMojo {
    /**
     * Mode is used to rise different types of ortau app as needed.
     */
    @Parameter(property = "mode", required = true)
    Mode mode;
    @Parameter(property = "project", required = true, readonly = true)
    MavenProject project;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        getLog().info(mode.toString());
        getLog().info(project.getCompileSourceRoots().toString());
    }
}
