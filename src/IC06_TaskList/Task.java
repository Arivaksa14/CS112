package IC06_TaskList;

import java.io.Serializable;
import java.util.Objects;
public class Task implements Serializable {
    private String mDeadline;
    private String mDueDate;
    private String mName;
    private int mPriority;

    public Task(String deadline, String dueDate, String name, int priority) {
        mDeadline = deadline;
        mDueDate = dueDate;
        mName = name;
        mPriority = priority;
    }

    public String getDeadline() {
        return mDeadline;
    }

    public String getDueDate() {
        return mDueDate;
    }

    public String getName() {
        return mName;
    }

    public int getPriority() {
        return mPriority;
    }

    public void setDeadline(String deadline) {
        mDeadline = deadline;
    }

    public void setDueDate(String dueDate) {
        mDueDate = dueDate;
    }

    public void setName(String name) {
        mName = name;
    }

    public void setPriority(int priority) {
        mPriority = priority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return mPriority == task.mPriority && Objects.equals(mDeadline, task.mDeadline) && Objects.equals(mDueDate, task.mDueDate) && Objects.equals(mName, task.mName);
    }
    @Override
    public int hashCode() {
        return Objects.hash(mDeadline, mDueDate, mName, mPriority);
    }
    @Override
    public String toString() {
        String priorityS="Low";
        if(mPriority==1){
            priorityS="High";
        }else if (mPriority==2){
           priorityS="Medium";
        }

        return "Task [" +
                "name=" + mName +
                ", dueDate=" + mDueDate +
                ", deadline=" + mDeadline +
                ", priority=" + priorityS +
                ']';
    }

}
