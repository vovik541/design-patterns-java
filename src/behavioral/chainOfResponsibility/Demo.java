package behavioral.chainOfResponsibility;

import behavioral.chainOfResponsibility.middleware.Middleware;
import behavioral.chainOfResponsibility.middleware.RoleCheckMiddleware;
import behavioral.chainOfResponsibility.middleware.ThrottlingMiddleware;
import behavioral.chainOfResponsibility.middleware.UserExistsMiddleware;
import behavioral.chainOfResponsibility.server.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Demo {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Server server;

    private static void init() {
        server = new Server();
        server.register("admin@example.com", "admin_pass");
        server.register("user@example.com", "user_pass");

        //All checks are linked. Client can build various chains using the
        Middleware middleware = Middleware.link(
            new ThrottlingMiddleware(2),
            new UserExistsMiddleware(server),
            new RoleCheckMiddleware()
        );

        //Server gets a chain from client code.
        server.setMiddleware(middleware);
    }

    public static void main(String[] args) throws IOException {
        init();

        boolean success;
        do {
            System.out.print("Enter email: ");
            String email = reader.readLine();
            System.out.print("Input password: ");
            String password = reader.readLine();
            success = server.logIn(email, password);
        } while (!success);
    }
}