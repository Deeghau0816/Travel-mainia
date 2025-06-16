function toggleAnswer(element) {
    const answer = element.nextElementSibling;
  
    // Toggle active arrow
    element.classList.toggle('active');
  
    // Toggle answer visibility
    if (answer.classList.contains('show')) {
      answer.classList.remove('show');
    } else {
      document.querySelectorAll('.answer').forEach(a => a.classList.remove('show'));
      document.querySelectorAll('.question').forEach(q => q.classList.remove('active'));
      answer.classList.add('show');
      element.classList.add('active');
    }
  }
  