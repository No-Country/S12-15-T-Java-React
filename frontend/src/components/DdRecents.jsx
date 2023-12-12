import Link from 'next/link';

function DdRecents() {
	return (
		<div>
			<ul className="menu">
				<li>
					<h2 className="dd-title">
						Recents
						<img src="/images/flecha.png" className="flecha" alt="" />
					</h2>

					<ul className="submenu">
						<li className="option">
							<Link className="link" href="#">
								Recent 1
							</Link>
						</li>
						<li className="option">
							<Link className="link" href="#">
								Recent 2
							</Link>
						</li>
						<li className="option">
							<Link className="link" href="#">
								Recent 3
							</Link>
						</li>
					</ul>
				</li>
			</ul>
		</div>
	);
}

export default DdRecents;
