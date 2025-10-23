using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using StudentManagement.Data;
using StudentManagement.Models;

namespace StudentManagement.Controllers
{
    public class StudentsController : Controller
    {
        private readonly AppDbContext _context;
        public StudentsController(AppDbContext context) { _context = context; }

        public async Task<IActionResult> Index() => View(await _context.Students.ToListAsync());

        public async Task<IActionResult> Details(int? id)
        {
            if (id == null) return NotFound();
            var student = await _context.Students.FirstOrDefaultAsync(m => m.Id == id);
            if (student == null) return NotFound();
            return View(student);
        }

        public IActionResult Create() => View();

        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Create([Bind("Id,Name,BirthDate,Address,SchoolName,Percentage")] Student student)
        {
            if (ModelState.IsValid) { _context.Add(student); await _context.SaveChangesAsync(); return RedirectToAction(nameof(Index)); }
            return View(student);
        }

        public async Task<IActionResult> Edit(int? id)
        {
            if (id == null) return NotFound();
            var student = await _context.Students.FindAsync(id);
            if (student == null) return NotFound();
            return View(student);
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Edit(int id, [Bind("Id,Name,BirthDate,Address,SchoolName,Percentage")] Student student)
        {
            if (id != student.Id) return NotFound();
            if (ModelState.IsValid)
            {
                try { _context.Update(student); await _context.SaveChangesAsync(); }
                catch (DbUpdateConcurrencyException)
                {
                    if (!_context.Students.Any(e => e.Id == student.Id)) return NotFound();
                    else throw;
                }
                return RedirectToAction(nameof(Index));
            }
            return View(student);
        }

        public async Task<IActionResult> Delete(int? id)
        {
            if (id == null) return NotFound();
            var student = await _context.Students.FirstOrDefaultAsync(m => m.Id == id);
            if (student == null) return NotFound();
            return View(student);
        }

        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> DeleteConfirmed(int id)
        {
            var student = await _context.Students.FindAsync(id);
            _context.Students.Remove(student);
            await _context.SaveChangesAsync();
            return RedirectToAction(nameof(Index));
        }
    }
}
