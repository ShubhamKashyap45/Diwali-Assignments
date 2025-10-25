using System.ComponentModel.DataAnnotations;

namespace StudentManagement.Models
{
    public class Course
    {
        [Key]
        public int CourseID { get; set; }

        [Required(ErrorMessage = "Course name is required")]
        [StringLength(200)]
        public string CourseName { get; set; }
    }
}
