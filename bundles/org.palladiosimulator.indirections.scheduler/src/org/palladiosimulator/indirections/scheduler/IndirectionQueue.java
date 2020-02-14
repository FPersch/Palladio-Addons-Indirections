package org.palladiosimulator.indirections.scheduler;

import java.util.ArrayDeque;
import java.util.Queue;

import org.palladiosimulator.indirections.interfaces.IndirectionDate;
import org.palladiosimulator.indirections.scheduler.scheduling.SuspendableSchedulerEntity;

public class IndirectionQueue<T extends SuspendableSchedulerEntity> {
    public final Queue<IndirectionDate> elements;
    public final Queue<T> processes;

    public IndirectionQueue() {
        this.elements = new ArrayDeque<>();
        this.processes = new ArrayDeque<>();
    }
}