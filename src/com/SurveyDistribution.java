package com;

import java.util.UUID;

public class SurveyDistribution {
 public static String generateSurveyLink() {
     return "http://example.com/survey?id=" + UUID.randomUUID();
 }
}

