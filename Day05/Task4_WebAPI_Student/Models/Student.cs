using System;
using System.ComponentModel.DataAnnotations;

namespace StudentApi.Models
{
    public class Student
    {
        public int Id { get; set; }

        [Required]
        public string Name { get; set; }

        [DataType(DataType.Date)]
        public DateTime BirthDate { get; set; }

        public string Address { get; set; }

        public string SchoolName { get; set; }

        [Range(0, 100)]
        public double Percentage { get; set; }
    }
}
