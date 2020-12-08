////////////////////////////////////////////////////////////////////
// [VITTORIO] [SCHIAVON] [1187243]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.model;
import java.time.LocalDate;

public class User {
    private String ID;
    private String name;
    private String surname;
    private LocalDate birthday;
    public User(String id, String Name, String Surname, LocalDate Birthday) {
        this.ID = id;
        this.name = Name;
        this.surname = Surname;
        this.birthday = Birthday;
    }
    public String getID() {
        return ID;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public LocalDate getBirthday() {
        return birthday;
    }
}
