
function confirmDeletion() {
    const checkboxes = document.querySelectorAll('input[name="selectedCards"]:checked');

    if (checkboxes.length === 0) {
        alert("Bitte wählen Sie mindestens eine Karteikarte aus.");
        return;
    }

    var result = confirm("Möchten Sie die ausgewählten Karteikarten wirklich löschen?");
    if (result) {
        document.getElementById('delete-form').submit();
    }
}

document.addEventListener('DOMContentLoaded', function() {
    fetchTagsAndPopulateDropdown();
});

function fetchTagsAndPopulateDropdown() {
    fetch('/api/flashcard-tags')
        .then(response => response.json())
        .then(tags => {
            const dropdownMenu = document.getElementById('tagDropdown');
            tags.forEach(tag => {
                const checkbox = document.createElement('input');
                checkbox.type = 'checkbox';
                checkbox.id = 'tag' + tag.id;
                checkbox.name = 'tags';
                checkbox.value = tag.id;
                checkbox.classList.add('form-check-input');

                const label = document.createElement('label');
                label.htmlFor = 'tag' + tag.id;
                label.classList.add('dropdown-item');
                label.appendChild(checkbox);
                label.append(tag.title);

                const listItem = document.createElement('li');
                listItem.appendChild(label);

                dropdownMenu.appendChild(listItem);
            });
        })
        .catch(error => console.error('Error fetching tags:', error));
}
document.getElementById('flashcardForm').addEventListener('submit', updateSelectedTags);

function filterFlashcardsByTags() {
    const selectedTagIds = Array.from(document.querySelectorAll('#tagDropdown input[type="checkbox"]:checked'))
        .map(checkbox => checkbox.value)
        .join(',');
    if (selectedTagIds.length > 0) {
        window.location.href = `/filterFlashcards?tags=${selectedTagIds}`;
    } else {
        alert("Bitte wählen Sie mindestens ein Tag aus, um zu filtern.");
    }
}
