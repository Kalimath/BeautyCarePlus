package domain.model;

public enum Role {
    ADMIN("Admin"), CONSULT("Consult"),UNAUTHORIZED("Unauthorized");

    private String roleName;

    private Role(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }
}
