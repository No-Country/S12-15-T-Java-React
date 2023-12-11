function Burguer() {
	return (
		<div>
			<label className="menuButton" htmlFor="check">
				<input type="checkbox" id="check" />
				<span className="top"></span>
				<span className="mid"></span>
				<span className="bot"></span>
			</label>
		</div>
	);
}

export default Burguer;
