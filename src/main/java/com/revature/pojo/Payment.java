package com.revature.pojo;

public class Payment {
	
	private Double award;
	
	private Double pending;
	
	private Double available;
	
	private final static Double TOTAL = 1000.0;

	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Payment(Double award, Double pending, Double available) {
		super();
		this.award = award;
		this.pending = pending;
		this.available = available;
	}

	public Double getAward() {
		return award;
	}

	public void setAward(Double award) {
		this.award = award;
	}

	public Double getPending() {
		return pending;
	}

	public void setPending(Double pending) {
		this.pending = pending;
	}

	public Double getAvailable() {
		return available;
	}

	public void setAvailable(Double available) {
		this.available = available;
	}

	public static Double getTotal() {
		return TOTAL;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((available == null) ? 0 : available.hashCode());
		result = prime * result + ((award == null) ? 0 : award.hashCode());
		result = prime * result + ((pending == null) ? 0 : pending.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payment other = (Payment) obj;
		if (available == null) {
			if (other.available != null)
				return false;
		} else if (!available.equals(other.available))
			return false;
		if (award == null) {
			if (other.award != null)
				return false;
		} else if (!award.equals(other.award))
			return false;
		if (pending == null) {
			if (other.pending != null)
				return false;
		} else if (!pending.equals(other.pending))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Payment [award=" + award + ", pending=" + pending + ", available=" + available + "]";
	}
	
	
//	AvailableReimburstment = TotalReimburstment ($1000) – PendingReimburstments – AwardedReimburstments

	
	
}
