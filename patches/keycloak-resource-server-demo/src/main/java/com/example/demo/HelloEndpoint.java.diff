diff --git a/src/main/java/com/example/demo/HelloEndpoint.java b/src/main/java/com/example/demo/HelloEndpoint.java
index 62a3924..e906b00 100644
--- a/src/main/java/com/example/demo/HelloEndpoint.java
+++ b/src/main/java/com/example/demo/HelloEndpoint.java
@@ -4,19 +4,21 @@ import org.springframework.security.access.annotation.Secured;
 import org.springframework.web.bind.annotation.GetMapping;
 import org.springframework.web.bind.annotation.RestController;
 
+import java.security.Principal;
+
 @RestController
 public class HelloEndpoint {
 
     @GetMapping("/admin/hello")
     @Secured("ROLE_ADMIN")
-    public String sayHelloToAdmin() {
-        return "Hello Admin";
+    public String sayHelloToAdmin(final Principal principal) {
+        return "Hello Admin: " + principal.getName();
     }
 
     @GetMapping("/user/hello")
     @Secured("ROLE_USER")
-    public String sayHelloToUser() {
-        return "Hello User";
+    public String sayHelloToUser(final Principal principal) {
+        return "Hello User: " + principal.getName();
     }
 
     @GetMapping("/guest/hello")
