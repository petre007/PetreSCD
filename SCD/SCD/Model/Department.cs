using System;
using System.Collections.Generic;

namespace SCD.Model
{
    public class Department
    {
        public int Id { get; set; }
        public String Description { get; set; }
        public Department Parent { get; set; }
        public HashSet<Department> DepartementChildren { get; set; }
    }
}