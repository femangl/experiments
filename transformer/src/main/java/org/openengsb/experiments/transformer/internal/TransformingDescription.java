package org.openengsb.experiments.transformer.internal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransformingDescription {
    private Class<?> source;
    private Class<?> target;
    private Map<String, TransformingStep> steps;

    public TransformingDescription(Class<?> source, Class<?> target) {
        this.source = source;
        this.target = target;
        steps = new HashMap<String, TransformingStep>();
    }

    public Class<?> getSource() {
        return source;
    }

    public Class<?> getTarget() {
        return target;
    }

    public void forwardField(String sourceField, String targetField) {
        TransformingStep step = new TransformingStep();
        step.setTargetField(targetField);
        step.setSourceFields(sourceField);
        step.setOperation(TransformOperation.FORWARD);
        steps.put(targetField, step);
    }

    public void concatField(String targetField, String concatString, String... sourceFields) {
        TransformingStep step = new TransformingStep();
        step.setTargetField(targetField);
        step.setSourceFields(sourceFields);
        step.setOperationParam(concatString);
        step.setOperation(TransformOperation.CONCAT);
        steps.put(targetField, step);
    }

    public List<TransformingStep> getTransformingSteps() {
        return new ArrayList<TransformingStep>(steps.values());
    }
}