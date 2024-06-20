document.addEventListener('DOMContentLoaded', function() {
    const policyTableContainer = document.getElementById('policyTableContainer');
    const addPolicyForm = document.getElementById('addPolicyForm');

    // Sample data for policies
    let policies = [
        { name: 'Policy 1', details: 'Details of Policy 1', type: 'Type 1' },
        { name: 'Policy 2', details: 'Details of Policy 2', type: 'Type 2' }
    ];

    // Function to render policy table
    function renderPolicyTable() {
        let tableHTML = `
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th onclick="sortPolicies('name')">Name</th>
                        <th>Details</th>
                        <th onclick="sortPolicies('type')">Type</th>
                    </tr>
                </thead>
                <tbody>
        `;

        policies.forEach(policy => {
            tableHTML += `
                <tr>
                    <td>${policy.name}</td>
                    <td>${policy.details}</td>
                    <td>${policy.type}</td>
                </tr>
            `;
        });

        tableHTML += `</tbody></table>`;
        policyTableContainer.innerHTML = tableHTML;
    }

    // Function to sort policies
    function sortPolicies(key) {
        policies.sort((a, b) => (a[key] > b[key]) ? 1 : -1);
        renderPolicyTable();
    }

    // Add new policy
    addPolicyForm.addEventListener('submit', function(event) {
        event.preventDefault();

        const policyName = document.getElementById('policyName').value;
        const policyDetails = document.getElementById('policyDetails').value;
        const policyType = document.getElementById('policyType').value;

        policies.push({ name: policyName, details: policyDetails, type: policyType });
        renderPolicyTable();

        $('#addPolicyModal').modal('hide');
        addPolicyForm.reset();
    });

    // Initial render of the policy table
    renderPolicyTable();
});