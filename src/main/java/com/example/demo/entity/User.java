// Example for User.java (Apply similar logic to others)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor // This fixes "constructor cannot be applied to given types"
@Builder // Optional, but helpful for tests
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String password;
    private String role;
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() { // Fixes "cannot find symbol method prePersist"
        this.createdAt = LocalDateTime.now();
    }
}