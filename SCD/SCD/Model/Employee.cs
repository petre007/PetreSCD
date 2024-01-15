using System;

namespace SCD.Model
{
    public class Employee
    {
        public int Id { get; set; }
        public Employee Manager { get; set; }
        public Department Department { get; set; }
        public String Email { get; set; }
    }
}