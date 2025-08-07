package lk.ijse.gdse71;

import lk.ijse.gdse71.config.WebAppConfig;
import lk.ijse.gdse71.config.WebRootConfig;
import org.jspecify.annotations.Nullable;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    // me method eken karanne webroot kiyana configuration class eka spring context ekata add kara ganna eka thamayi meken karanne
    @Override
    protected Class<?> @Nullable [] getRootConfigClasses() {
        return new Class[]{WebRootConfig.class};
    }

    // me method eken karanne webApp configuration class eka spring context ekata da ganna eka
    @Override
    protected Class<?> @Nullable [] getServletConfigClasses() {
        return new Class[]{WebAppConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
