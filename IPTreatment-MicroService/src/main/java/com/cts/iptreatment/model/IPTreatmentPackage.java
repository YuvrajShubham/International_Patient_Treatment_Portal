package com.cts.iptreatment.model;

import lombok.Data;

@Data
public class IPTreatmentPackage {
	private int treatmentPackageId;
	private AilmentCategory ailmentCategory;
	private PackageDetail packageDetail;
}
