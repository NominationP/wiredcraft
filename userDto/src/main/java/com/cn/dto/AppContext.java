package com.cn.dto;

import com.cn.entity.UserDetail;
import lombok.Data;

import java.io.Serializable;

@Data
public class AppContext implements Serializable {
    public static final String TRACE_ID_HEADER = "Trace-Id";
    private static final long serialVersionUID = -979220111440953115L;

    private String traceId;
    private UserDetail userInfo;

    private static final ThreadLocal<AppContext> LOCAL = ThreadLocal.withInitial(AppContext::new);

    public static AppContext getContext() {
        return LOCAL.get();
    }

    public static void setContext(AppContext context) {
        LOCAL.set(context);
    }

    public static void removeContext() {
        LOCAL.remove();
    }
}
