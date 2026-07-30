class Q11_Job {
    private String id;
    private String owner;
    private int priority;

    public Q11_Job(String id, String owner, int priority) {
        this.id = id;
        this.owner = owner;
        this.priority = priority;
    }

    public String getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return id + " " + owner + " priority=" + priority;
    }
}

public class Q11_JobSorter {

    public static void main(String[] args) {
        Q11_Job[] jobs = {
            new Q11_Job("J201", "Amy", 3),
            new Q11_Job("J105", "Ben", 5),
            new Q11_Job("J330", "Cara", 3),
            new Q11_Job("J118", "Dan", 5),
            new Q11_Job("J450", "Amy", 1)
        };

        mergeSortByPriority(jobs);

        for (Q11_Job job : jobs) {
            System.out.println(job);
        }

        System.out.println("搜尋 Amy：" +
            findFirstByOwner(jobs, "amy"));
    }

    public static void mergeSortByPriority(Q11_Job[] jobs) {
        if (jobs == null || jobs.length < 2) {
            return;
        }

        Q11_Job[] buffer = new Q11_Job[jobs.length];
        sort(jobs, buffer, 0, jobs.length);
    }

    private static void sort(
        Q11_Job[] jobs,
        Q11_Job[] buffer,
        int start,
        int end
    ) {
        if (end - start <= 1) {
            return;
        }

        int middle = start + (end - start) / 2;

        sort(jobs, buffer, start, middle);
        sort(jobs, buffer, middle, end);

        combine(jobs, buffer, start, middle, end);
    }

    private static void combine(
        Q11_Job[] jobs,
        Q11_Job[] buffer,
        int start,
        int middle,
        int end
    ) {
        int left = start;
        int right = middle;
        int position = start;

        while (left < middle && right < end) {
            Q11_Job leftJob = jobs[left];
            Q11_Job rightJob = jobs[right];

            if (leftJob.getPriority() >= rightJob.getPriority()) {
                buffer[position] = leftJob;
                left++;
            } else {
                buffer[position] = rightJob;
                right++;
            }

            position++;
        }

        while (left < middle) {
            buffer[position] = jobs[left];
            left++;
            position++;
        }

        while (right < end) {
            buffer[position] = jobs[right];
            right++;
            position++;
        }

        for (int index = start; index < end; index++) {
            jobs[index] = buffer[index];
        }
    }

    public static Q11_Job findFirstByOwner(
        Q11_Job[] jobs,
        String owner
    ) {
        if (jobs == null || owner == null) {
            return null;
        }

        for (int index = 0; index < jobs.length; index++) {
            Q11_Job current = jobs[index];

            if (current == null) {
                continue;
            }

            String currentOwner = current.getOwner();

            if (currentOwner != null &&
                currentOwner.equalsIgnoreCase(owner)) {
                return current;
            }
        }

        return null;
    }
}