[INFO] 12 errors 
[INFO] -------------------------------------------------------------
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  15.912 s
[INFO] Finished at: 2025-12-21T11:05:19Z
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.11.0:compile (default-compile) on project demo: Compilation failure: Compilation failure: 
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/UserServiceImpl.java:[11,8] com.example.demo.service.impl.UserServiceImpl is not abstract and does not override abstract method existsByEmail(java.lang.String) in com.example.demo.service.UserService
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/UserServiceImpl.java:[19,5] method does not override or implement a method from a supertype
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/UserServiceImpl.java:[24,5] method does not override or implement a method from a supertype
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/UserServiceImpl.java:[30,5] method does not override or implement a method from a supertype
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/controller/AuthController.java:[34,31] cannot find symbol
[ERROR]   symbol:   method generateTokenForUser(com.example.demo.entity.User)
[ERROR]   location: variable jwtUtil of type com.example.demo.security.JwtUtil
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/ActivityCategoryServiceImpl.java:[23,53] cannot find symbol
[ERROR]   symbol:   method getCategoryName()
[ERROR]   location: variable category of type com.example.demo.entity.ActivityCategory
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/ActivityLogServiceImpl.java:[40,16] cannot find symbol
[ERROR]   symbol:   method getActivityDate()
[ERROR]   location: variable log of type com.example.demo.entity.ActivityLog
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/ActivityLogServiceImpl.java:[47,12] cannot find symbol
[ERROR]   symbol:   method setUser(com.example.demo.entity.User)
[ERROR]   location: variable log of type com.example.demo.entity.ActivityLog
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/ActivityLogServiceImpl.java:[48,12] cannot find symbol
[ERROR]   symbol:   method setActivityType(com.example.demo.entity.ActivityType)
[ERROR]   location: variable log of type com.example.demo.entity.ActivityLog
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/ActivityLogServiceImpl.java:[49,12] cannot find symbol
[ERROR]   symbol:   method setEstimatedEmission(double)
[ERROR]   location: variable log of type com.example.demo.entity.ActivityLog
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/controller/ActivityLogController.java:[28,12] cannot find symbol
[ERROR]   symbol:   method setActivityDate(java.time.LocalDate)
[ERROR]   location: variable log of type com.example.demo.entity.ActivityLog
[ERROR] /home/coder/Workspace/demo/src/main/java/com/example/demo/service/impl/EmissionFactorServiceImpl.java:[35,32] incompatible types: com.example.demo.entity.ActivityType cannot be converted to java.lang.String
[ERROR] -> [Help 1]
[ERROR] 
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR] 
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException