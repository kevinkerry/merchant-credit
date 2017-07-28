package com.sdp.mc;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class TePcs {

	public static void main(String[] args) throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd-HH");
		String suffix = dateFormat.format(new Date());
		String inputFile = "K:\\tt\\tt.csv";
		String outputFile = "K:\\tt\\pcs_merc_" + suffix + ".sql";

		File file = new File(inputFile);
		List<String> l = FileUtils.readLines(file);
		List<String> ll = new ArrayList<String>();

		StringBuffer sb = null;
		for (String ss : l) {
			sb = new StringBuffer();
			String[] v = ss.split(",");

			String merchantNo = v[0];
			String minLimit = v[1];
			String limit = v[2];

			sb.append("update pcs.merchant_settle ms set ms.fast_settle_min_limit = " + minLimit + " , ms.fast_settle_limit = ");
			sb.append(limit);
			sb.append(" where ms.merchant_no = '");
			sb.append(merchantNo);
			sb.append("';");
			ll.add(sb.toString());
			// if(i++ %100 == 0){
			// ll.add("commit;");
			// }
		}
		// ll.add("commit;");
		File outFile = new File(outputFile);
		// FileUtils.writeLines(outFile, ll, false);
		FileUtils.writeLines(outFile, "UTF-8", ll);
	}

}
