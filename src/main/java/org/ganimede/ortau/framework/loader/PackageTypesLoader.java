package org.ganimede.ortau.framework.loader;

import javax.inject.Named;
import javax.inject.Singleton;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

@Named
@Singleton
public class PackageTypesLoader {
    public List<Class<?>> getPackageClasses(String root) {
        try (InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream(root.replaceAll("[.]", "/"))) {
            assert stream != null;
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            return reader.lines().map(line -> getClass(line, root)).collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private Class<?> getClass(String className, String packageName) {
        try {
            return Class.forName(packageName + "."
                    + className.substring(0, className.lastIndexOf('.')));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
