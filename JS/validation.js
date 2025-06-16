function validateForm() {
  const stdate = document.getElementById("stdate").value;
  const edate = document.getElementById("edate").value;

  if (!stdate) {
    alert("Please select a Start Date.");
    return false;
  }

  if (!edate) {
    alert("Please select an End Date.");
    return false;
  }

  if (stdate > edate) {
    alert("End Date must be after Start Date.");
    return false;
  }

  return true;
}
