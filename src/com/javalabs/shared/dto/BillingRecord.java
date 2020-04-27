package com.javalabs.shared.dto;

import java.io.Serializable;
import java.util.Date;

import javax.ws.rs.QueryParam;

public class BillingRecord implements Serializable {

	private static final long serialVersionUID = 1L;

	@QueryParam("id")	
	private Long id;
	@QueryParam("FileName")
	private String FileName;
	@QueryParam("Timestamp")
	private Date Timestamp;
	@QueryParam("CallType")
	private String CallType;
	@QueryParam("CallCause")
	private String CallCause;
	@QueryParam("CustomerIdentifir")
	private String CustomerIdentifir;
	@QueryParam("TelephoneNumberDialled")
	private String TelephoneNumberDialled;
	@QueryParam("CallDate")
	private String CallDate;
	@QueryParam("CallTime")
	private String CallTime;
	@QueryParam("Duration")
	private String Duration;
	@QueryParam("BytesTransmitted")
	private String BytesTransmitted;
	@QueryParam("BytesReceived")
	private String BytesReceived;
	@QueryParam("Description")
	private String Description;
	@QueryParam("Chargecode")
	private String Chargecode;
	@QueryParam("TimeBand")
	private String TimeBand;
	@QueryParam("Salesprice")
	private String Salesprice;
	@QueryParam("SalespricePreBundle")
	private String SalespricePreBundle;
	@QueryParam("Extension")
	private String Extension;
	@QueryParam("DDI")
	private String DDI;
	@QueryParam("GroupingID")
	private String GroupingID;
	@QueryParam("CallClass")
	private String CallClass;
	@QueryParam("Carrier")
	private String Carrier;
	@QueryParam("Recording")
	private String Recording;
	@QueryParam("VAT")
	private String VAT;
	@QueryParam("CountryOfOrigin")
	private String CountryOfOrigin;
	@QueryParam("Network")
	private String Network;
	@QueryParam("RetailTariffCode")
	private String RetailTariffCode;
	@QueryParam("RemoteNetwork")
	private String RemoteNetwork;
	@QueryParam("APN")
	private String APN;
	@QueryParam("DivertedNumber")
	private String DivertedNumber;
	@QueryParam("RingTime")
	private String RingTime;
	@QueryParam("RecordID")
	private String RecordID;
	@QueryParam("Currency")
	private String Currency;
	@QueryParam("PresentationNumber")
	private String PresentationNumber;
	@QueryParam("NetworkAccessReference")
	private String NetworkAccessReference;
	@QueryParam("NGCSAccessCharge")
	private String NGCSAccessCharge;
	@QueryParam("NGCSServiceCharge")
	private String NGCSServiceCharge;
	@QueryParam("TotalBytesTransferred")
	private String TotalBytesTransferred;
	@QueryParam("UserID")
	private String UserID;
	@QueryParam("OnwardBillingReference")
	private String OnwardBillingReference;
	@QueryParam("ContractName")
	private String ContractName;
	@QueryParam("BundleName")
	private String BundleName;
	@QueryParam("BundleAllowance")
	private String BundleAllowance;
	@QueryParam("DiscountReference")
	private String DiscountReference;
	@QueryParam("RoutingCode")
	private String RoutingCode;

	public BillingRecord() {}

	public BillingRecord(Long id, String fileName, Date timestamp, String callType, String callCause, String customerIdentifir,
			String telephoneNumberDialled, String callDate, String callTime, String duration, String bytesTransmitted,
			String bytesReceived, String description, String chargecode, String timeBand, String salesprice,
			String salespricePreBundle, String extension, String dDI, String groupingID, String callClass,
			String carrier, String recording, String vAT, String countryOfOrigin, String network,
			String retailTariffCode, String remoteNetwork, String aPN, String divertedNumber, String ringTime,
			String recordID, String currency, String presentationNumber, String networkAccessReference,
			String nGCSAccessCharge, String nGCSServiceCharge, String totalBytesTransferred, String userID,
			String onwardBillingReference, String contractName, String bundleName, String bundleAllowance,
			String discountReference, String routingCode) {
		
		super();
		
		this.id = id;
		FileName = fileName;
		Timestamp = timestamp;
		CallType = callType;
		CallCause = callCause;
		CustomerIdentifir = customerIdentifir;
		TelephoneNumberDialled = telephoneNumberDialled;
		CallDate = callDate;
		CallTime = callTime;
		Duration = duration;
		BytesTransmitted = bytesTransmitted;
		BytesReceived = bytesReceived;
		Description = description;
		Chargecode = chargecode;
		TimeBand = timeBand;
		Salesprice = salesprice;
		SalespricePreBundle = salespricePreBundle;
		Extension = extension;
		DDI = dDI;
		GroupingID = groupingID;
		CallClass = callClass;
		Carrier = carrier;
		Recording = recording;
		VAT = vAT;
		CountryOfOrigin = countryOfOrigin;
		Network = network;
		RetailTariffCode = retailTariffCode;
		RemoteNetwork = remoteNetwork;
		APN = aPN;
		DivertedNumber = divertedNumber;
		RingTime = ringTime;
		RecordID = recordID;
		Currency = currency;
		PresentationNumber = presentationNumber;
		NetworkAccessReference = networkAccessReference;
		NGCSAccessCharge = nGCSAccessCharge;
		NGCSServiceCharge = nGCSServiceCharge;
		TotalBytesTransferred = totalBytesTransferred;
		UserID = userID;
		OnwardBillingReference = onwardBillingReference;
		ContractName = contractName;
		BundleName = bundleName;
		BundleAllowance = bundleAllowance;
		DiscountReference = discountReference;
		RoutingCode = routingCode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFileName() {
		return FileName;
	}

	public void setFileName(String fileName) {
		FileName = fileName;
	}

	public Date getTimestamp() {
		return Timestamp;
	}

	public void setTimestamp(Date timestamp) {
		Timestamp = timestamp;
	}
	
	public String getCallType() {
		return CallType;
	}

	public void setCallType(String callType) {
		CallType = callType;
	}

	public String getCallCause() {
		return CallCause;
	}

	public void setCallCause(String callCause) {
		CallCause = callCause;
	}

	public String getCustomerIdentifir() {
		return CustomerIdentifir;
	}

	public void setCustomerIdentifir(String customerIdentifir) {
		CustomerIdentifir = customerIdentifir;
	}

	public String getTelephoneNumberDialled() {
		return TelephoneNumberDialled;
	}

	public void setTelephoneNumberDialled(String telephoneNumberDialled) {
		TelephoneNumberDialled = telephoneNumberDialled;
	}

	public String getCallDate() {
		return CallDate;
	}

	public void setCallDate(String callDate) {
		CallDate = callDate;
	}

	public String getCallTime() {
		return CallTime;
	}

	public void setCallTime(String callTime) {
		CallTime = callTime;
	}

	public String getDuration() {
		return Duration;
	}

	public void setDuration(String duration) {
		Duration = duration;
	}

	public String getBytesTransmitted() {
		return BytesTransmitted;
	}

	public void setBytesTransmitted(String bytesTransmitted) {
		BytesTransmitted = bytesTransmitted;
	}

	public String getBytesReceived() {
		return BytesReceived;
	}

	public void setBytesReceived(String bytesReceived) {
		BytesReceived = bytesReceived;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getChargecode() {
		return Chargecode;
	}

	public void setChargecode(String chargecode) {
		Chargecode = chargecode;
	}

	public String getTimeBand() {
		return TimeBand;
	}

	public void setTimeBand(String timeBand) {
		TimeBand = timeBand;
	}

	public String getSalesprice() {
		return Salesprice;
	}

	public void setSalesprice(String salesprice) {
		Salesprice = salesprice;
	}

	public String getSalespricePreBundle() {
		return SalespricePreBundle;
	}

	public void setSalespricePreBundle(String salespricePreBundle) {
		SalespricePreBundle = salespricePreBundle;
	}

	public String getExtension() {
		return Extension;
	}

	public void setExtension(String extension) {
		Extension = extension;
	}

	public String getDDI() {
		return DDI;
	}

	public void setDDI(String dDI) {
		DDI = dDI;
	}

	public String getGroupingID() {
		return GroupingID;
	}

	public void setGroupingID(String groupingID) {
		GroupingID = groupingID;
	}

	public String getCallClass() {
		return CallClass;
	}

	public void setCallClass(String callClass) {
		CallClass = callClass;
	}

	public String getCarrier() {
		return Carrier;
	}

	public void setCarrier(String carrier) {
		Carrier = carrier;
	}

	public String getRecording() {
		return Recording;
	}

	public void setRecording(String recording) {
		Recording = recording;
	}

	public String getVAT() {
		return VAT;
	}

	public void setVAT(String vAT) {
		VAT = vAT;
	}

	public String getCountryOfOrigin() {
		return CountryOfOrigin;
	}

	public void setCountryOfOrigin(String countryOfOrigin) {
		CountryOfOrigin = countryOfOrigin;
	}

	public String getNetwork() {
		return Network;
	}

	public void setNetwork(String network) {
		Network = network;
	}

	public String getRetailTariffCode() {
		return RetailTariffCode;
	}

	public void setRetailTariffCode(String retailTariffCode) {
		RetailTariffCode = retailTariffCode;
	}

	public String getRemoteNetwork() {
		return RemoteNetwork;
	}

	public void setRemoteNetwork(String remoteNetwork) {
		RemoteNetwork = remoteNetwork;
	}

	public String getAPN() {
		return APN;
	}

	public void setAPN(String aPN) {
		APN = aPN;
	}

	public String getDivertedNumber() {
		return DivertedNumber;
	}

	public void setDivertedNumber(String divertedNumber) {
		DivertedNumber = divertedNumber;
	}

	public String getRingTime() {
		return RingTime;
	}

	public void setRingTime(String ringTime) {
		RingTime = ringTime;
	}

	public String getRecordID() {
		return RecordID;
	}

	public void setRecordID(String recordID) {
		RecordID = recordID;
	}

	public String getCurrency() {
		return Currency;
	}

	public void setCurrency(String currency) {
		Currency = currency;
	}

	public String getPresentationNumber() {
		return PresentationNumber;
	}

	public void setPresentationNumber(String presentationNumber) {
		PresentationNumber = presentationNumber;
	}

	public String getNetworkAccessReference() {
		return NetworkAccessReference;
	}

	public void setNetworkAccessReference(String networkAccessReference) {
		NetworkAccessReference = networkAccessReference;
	}

	public String getNGCSAccessCharge() {
		return NGCSAccessCharge;
	}

	public void setNGCSAccessCharge(String nGCSAccessCharge) {
		NGCSAccessCharge = nGCSAccessCharge;
	}

	public String getNGCSServiceCharge() {
		return NGCSServiceCharge;
	}

	public void setNGCSServiceCharge(String nGCSServiceCharge) {
		NGCSServiceCharge = nGCSServiceCharge;
	}

	public String getTotalBytesTransferred() {
		return TotalBytesTransferred;
	}

	public void setTotalBytesTransferred(String totalBytesTransferred) {
		TotalBytesTransferred = totalBytesTransferred;
	}

	public String getUserID() {
		return UserID;
	}

	public void setUserID(String userID) {
		UserID = userID;
	}

	public String getOnwardBillingReference() {
		return OnwardBillingReference;
	}

	public void setOnwardBillingReference(String onwardBillingReference) {
		OnwardBillingReference = onwardBillingReference;
	}

	public String getContractName() {
		return ContractName;
	}

	public void setContractName(String contractName) {
		ContractName = contractName;
	}

	public String getBundleName() {
		return BundleName;
	}

	public void setBundleName(String bundleName) {
		BundleName = bundleName;
	}

	public String getBundleAllowance() {
		return BundleAllowance;
	}

	public void setBundleAllowance(String bundleAllowance) {
		BundleAllowance = bundleAllowance;
	}

	public String getDiscountReference() {
		return DiscountReference;
	}

	public void setDiscountReference(String discountReference) {
		DiscountReference = discountReference;
	}

	public String getRoutingCode() {
		return RoutingCode;
	}

	public void setRoutingCode(String routingCode) {
		RoutingCode = routingCode;
	}
	
}
