import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Courses")

public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int duration;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum('DESIGN', 'PROGRAMMING', 'MARKETING', 'MANAGMENT', 'BUSINESS')")
    private CourseType type;

    private String description;

    @ManyToOne(cascade = CascadeType.REFRESH)
    private Teacher teacher;

    @Column(name = "students_count")
    private int studentsCount;

    private int price;

    @Column(name = "price_per_hour")
    private float pricePerHour;

    @ManyToMany(cascade = CascadeType.REFRESH)
    @JoinTable(name = "Subscriptions",
        joinColumns = {@JoinColumn(name = "course_id")},
        inverseJoinColumns = {@JoinColumn(name = "student_id")}
    )

    // mappedBy = "id.course" - имеет такой вид в том случае если используется @EmbededId и поле с ключем в классе Subscriptions имеет название id
    @OneToMany(mappedBy = "id.course", cascade = CascadeType.ALL) // Вот тут мы уже можем использовать CascadeType.ALL так как если удаляется курс, то пускай и подписки удаляются, а если уж удаление делается каскадно, то и остальные действия тоже можно делать каскадно :)
    private List<Subscription> subscriptions = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public CourseType getType() {
        return type;
    }

    public void setType(CourseType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public int getStudentsCount() {
        return studentsCount;
    }

    public void setStudentsCount(int studentsCount) {
        this.studentsCount = studentsCount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public float getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(float pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public void addStudent(Student student) {
        subscriptions.add(new Subscription(this, student, new Date())); // Добавляем подписку студенту на текущий курс с текущей датой :)
    }
}
