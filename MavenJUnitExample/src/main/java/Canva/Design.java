package Canva;

import java.util.UUID;

public class Design {
    private AuthContext ctx;

    private String designContent;

    private String id;

    public Design(AuthContext ctx, String designContent) {
        this.ctx = ctx;
        this.designContent = designContent;
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public String getDesignContent() {
        return designContent;
    }
}
