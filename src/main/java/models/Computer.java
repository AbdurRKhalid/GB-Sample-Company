package models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Computer")
@NamedQueries({
        @NamedQuery(name = "Computer.findAll", query = "select c from Computer c")
})
public class Computer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "MACAddress", nullable = false)
    private String macAddress;

    @Column(name = "ComputerName", nullable = false)
    private String computerName;

    @Column(name = "IPAddress", nullable = false)
    private String ipAddress;

    @Column(name = "EmployeeAbbreviation")
    private String employeeAbbreviation;

    @Column(name = "Description")
    private String description;

}
